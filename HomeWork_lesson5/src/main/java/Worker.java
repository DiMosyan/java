public class Worker {

    private String name;
    private String post;
    private String email;
    private String tel;
    private int salary;
    private int age;

    public Worker(String name, String post,  String email, String tel, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }

    public void dataOutput() {
        System.out.println("Name - " + name);
        System.out.println("Post - " + post);
        System.out.println("Email - " + email);
        System.out.println("Telephone - " + tel);
        System.out.println("Salary - " + salary);
        System.out.println("Age - " + age);
        System.out.println();
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        printWorkers(initWorkers());

    }

    public static Worker[] initWorkers() {
        Worker[] workers = new Worker[5];
        workers[0] = new Worker("Akulenkov R.", "Developer", "Akula@mail.ru", "+7(999)824-32-50", 52000, 28);
        workers[1] = new Worker("Belikov A.", "Web-developer", "Belii@mail.ru", "+7(906)218-13-15", 60000, 26);
        workers[2] = new Worker("Gorshkova D.", "Front-end developer", "Gorshkova1972@mail.ru", "+7(909)315-98-74", 65000, 50);
        workers[3] = new Worker("Eremin I.", "Back-end developer", "Erema75@mail.ru", "+7(999)812-25-40", 65000, 47);
        workers[4] = new Worker("Yurk K.", "Android developer", "Yurk1@mail.ru", "+7(906)345-88-50", 70000, 38);
        return workers;
    }

    public static void printWorkers(Worker[] workers) {
        for (int i = 0; i < workers.length; i++) {
            if(workers[i].getAge() >= 40) {
                workers[i].dataOutput();
            }
        }
    }
}
