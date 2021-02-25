import org.hibernate.Session;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        StudentQuery.condition(session);
        HibernateUtil.shutdown();
    }
}
