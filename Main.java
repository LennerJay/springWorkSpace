
//understanding the concept of interface 

public class Main {
    public static void main(String[] args) {

        CodeService service = new CodeService(new Laptop("asus"));
        CodeService service2 = new CodeService(new Desktop("RedDragon"));
        service.doCoding();
        service.typeOfComputer();
        service2.doCoding();
        service2.typeOfComputer();
    }
}

class CodeService {
    Computer com;

    CodeService(Computer com) {
        this.com = com;
    }

    public void doCoding() {
        com.code();
    }

    public void typeOfComputer() {
        System.out.println(com.getType());
    }
}

/**
 * Computer
 */
interface Computer {
    public void code();

    public String getType();

}

class Laptop implements Computer {
    String model;

    Laptop(String model) {
        this.model = model;
    }

    public void code() {
        System.out.println("coding from laptop");
    }

    public String getType() {
        return model;
    };
}

class Desktop implements Computer {
    String type;

    Desktop(String type) {
        this.type = type;
    };

    public void code() {
        System.out.println("coding from desktop");
    }

    public String getType() {
        return type;
    }

}