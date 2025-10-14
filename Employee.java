public class Employee {
    public static void main(String args[]) {
        Employee.OvertimeCalculator ot_calc = new Employee.OvertimeCalculator();
        ot_calc.set_rate(0.5);
        System.out.println("The current overtime rate is " + ot_calc.get_rate());

        Employee kelly = new Employee();
        kelly.salary = 150.0;
        kelly.name = "Kelly Belly";
        double salary_for_period = kelly.get_pay_for_period(ot_calc.get_rate());
        System.out.println("Salary for " + kelly.name + "is " + salary_for_period);
    }

    String name;
    double salary;

    public double get_pay_for_period(double added_ot) {
        return salary + (salary * added_ot);
    }

    static class OvertimeCalculator {
        private double added_percentage;

        public void set_rate(double rate) {
            added_percentage = rate;
        }

        public double get_rate() {
            return added_percentage;
        }

        public double get_overtime(double salary) {
            return salary * added_percentage;
        }
    }
}
