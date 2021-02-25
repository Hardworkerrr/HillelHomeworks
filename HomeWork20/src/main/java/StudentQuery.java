import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class StudentQuery {

    public static void outputQuery(Session session){
        Query q = session.createQuery("From Student");
        System.out.println("Вывод всех ID и фамилий студентов : ");
        List<Student> resultList = q.list();
        for (Student student : resultList) {
            System.out.println("ID студента : " + student.getId());
            System.out.println("Имя студента : " + student.getFullname());
            System.out.println("=================================");
        }
    }

    public static void deleteByValuesQuery(Session session){
        boolean notFinished = true;
        while (notFinished) {
            Student student = new Student();
            System.out.println("Введите полное имя студента : ");
            student.setFullname(new Scanner(System.in).nextLine());
            System.out.println("Введите группу студента : ");
            student.setGroup(new Scanner(System.in).nextLine());
            System.out.println("Введите год поступления студента : ");
            student.setAdmission_year(new Scanner(System.in).nextInt());
            session.createQuery("DELETE Student WHERE fullname = :fullname and group_name = :group_name and admission_year= :admission_year")
                    .setParameter("fullname",student.getFullname())
                    .setParameter("group_name",student.getGroup())
                    .setParameter("admission_year",student.getAdmission_year())
                    .executeUpdate();
            System.out.println("Желаете ли вы закончить удаление студентов ? да,нет");
            switch (new Scanner(System.in).nextLine()) {
                case "да":
                    notFinished = false;
                    break;
                case "нет":
                    notFinished = true;
                    break;
            }
        }
    }

    public static void deleteByIDQuery(Session session){
        boolean notFinished = true;
        while (notFinished) {
            try {
                session.beginTransaction();
                System.out.println("Введите ID студента : ");
                Student student = (Student) session.load("Student", new Scanner(System.in).nextLong());
                session.delete(student);
                session.getTransaction().commit();
            }
            catch (ObjectNotFoundException ex){
                System.out.println("No Student with this id");
            }
            System.out.println("Желаете ли вы закончить удаление студентов ? да,нет");
            switch (new Scanner(System.in).nextLine()) {
                case "да":
                    notFinished = false;
                    break;
                case "нет":
                    notFinished = true;
                    break;
            }
        }
    }

    public static void addQuery(Session session){
        boolean notFinished = true;
        while (notFinished) {
            System.out.println("Введите полное имя студента : ");
            String fullName = new Scanner(System.in).nextLine();
            System.out.println("Введите группу студента : ");
            String group = new Scanner(System.in).nextLine();
            System.out.println("Введите год поступления студента : ");
            int year = new Scanner(System.in).nextInt();
            session.beginTransaction();
            session.save(new Student().setFullname(fullName).setGroup(group).setAdmission_year(year));
            session.getTransaction().commit();
            System.out.println("Желаете ли вы закончить добавление студентов ? да,нет");
            switch (new Scanner(System.in).nextLine()) {
                case "да":
                    notFinished = false;
                    break;
                case "нет":
                    notFinished = true;
                    break;
            }
        }
    }

    public static void condition(Session session){
        do {
            System.out.println("Какое действие вы хотите совершить в база данных ? 1-удалить студента, 2-добавить студента, 3-вывести информацию о всех студентах");
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    System.out.println("Каким именно способом вы хотите удалить студента ? 1-по индексу, 2-по значению");
                    switch (new Scanner(System.in).nextInt()) {
                        case 1:
                            deleteByIDQuery(session);
                            break;
                        case 2:
                            deleteByValuesQuery(session);
                            break;
                        default:
                            System.out.println("Вы ввели неправильное значение...");
                            condition(session);
                    }
                    break;
                case 2:
                    addQuery(session);
                    break;
                case 3:
                    outputQuery(session);
                    break;
                default:
                    System.out.println("Вы ввели неправильное число...");
                    condition(session);
            }
            System.out.println("Хотите ли вы совершить еще какие-либо действия ?: да,нет");
        }while (new Scanner(System.in).nextLine().toLowerCase().equals("да"));
    }
}
