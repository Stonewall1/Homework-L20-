package DBTask;

public class Main {
    public static void main(String[] args) {
        RetrievingInfoFromDatabase data = new RetrievingInfoFromDatabase();
        data.getFullDBInfo();
        data.getListOfStudents();

        OperationsWithDatabase operations = new OperationsWithDatabase();
        operations.deleteByStudentName();
        operations.deleteByCountry();
        operations.insertInfo();
    }
}
