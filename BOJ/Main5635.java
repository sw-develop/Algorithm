import java.util.*;

class Student implements Comparable<Student> {
    public String name;
    public int day;
    public int month;
    public int year;
    
    public Student(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    @Override
    public int compareTo(Student other) {
        // 나이 오름차순
        // -1 : this가 더 어릴 때, 1 : this가 더 많을 때 
        if(this.year > other.year) return -1;
        else if(this.year == other.year) {
            if(this.month > other.month) return -1;
            else if(this.month == other.month) {
                if(this.day > other.day) return -1;
                else return 1;
            }
            else {
                return 1;
            }
        }
        else {
            return 1;
        }        
    }
    
}

class Main {
    public static ArrayList<Student> list = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        
        int n = kbd.nextInt();
        
        for(int i = 0; i < n; i++) {
            Student stu = new Student(kbd.next(), kbd.nextInt(), kbd.nextInt(), kbd.nextInt());
            list.add(stu);
        }
        Collections.sort(list);
        
        System.out.println(list.get(0).name + "\n" + list.get(list.size()-1).name);
    }
}