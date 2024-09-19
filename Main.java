
//understanding the concept of interface
// understanding the concept of IoC and DI

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

/**
 * 3 types of interface
 * 1. normal interface (more than 1 methods)
 * -------
 * interface normalInterface
 * {
 * method1()
 * method2()
 * }
 * -------
 * 2. functional interface / SAM(Single Abstract Method)
 * purpose? declaring methods(logic) after initialization, for instance
 * 
 * interface functionalInterface
 * {
 * method();
 * }
 * use case
 * 
 * functionalInterface fi = new functionalInterface(){
 * @Override
 * method()
 * {
 * [do something]
 * }
 * };
 * 
 * 
 * 3. marker interface (no methods)
 * purpose? for serialization / disseria..
 * just think of anonymous object that has value and that object should
 * put/store in
 * the harddrive
 * remember this fcker -> anonymous object in the heap memory to hard
 * drive(serialization)
 * and the opposite is disserialization
 * similar concept of caching i guess :)
 * 
 */
