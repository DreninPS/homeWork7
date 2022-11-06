import java.util.Arrays;

public class MyCollectionImpl implements Collection{

    public MyCollectionImpl() {
        this.massConstruct = new String[5];
        isEmpty = true;
        flag = 0;
    }
    public MyCollectionImpl(String[] mass) {
        this.massConstruct = mass;
        flag = mass.length-1;
        isEmpty = false;
    }

    private String [] massConstruct;
    private int flag;
    private boolean isEmpty;

    private void incrSizeMassFilling (){
        if(massConstruct.length<=flag+1){
            String [] incrMass = new String[massConstruct.length+5];
            for (int i = 0; i < massConstruct.length; i++) {incrMass[i] = massConstruct[i];}
            massConstruct = incrMass;
        }
    }
    private void addByIndex(int index, String value){
        for (int i = flag; i >= index ; i--) {
            massConstruct[i+1] = massConstruct[i];
        }
        massConstruct[index] = value;
        flag++;
        System.out.println(Arrays.toString(massConstruct));
    }

    private void decrSizeMassFilling (){
        int count =0;
        for (int i = flag; i <massConstruct.length ; i++) {
            count++;
        }
        if (count>10){
            String[] decrMass =new String[massConstruct.length-5];
            for (int i = 0; i < decrMass.length; i++) {
                decrMass[i] = massConstruct[i];
            }
            massConstruct = decrMass;
        }
    }

    private void deleteElement(int index) {
        for (int i = index; i <=flag ; i++) {
            massConstruct[i] = massConstruct[i+1];
        }
        flag--;
        if (flag ==-1) {
            isEmpty = true;
            flag = 0;
        }
        System.out.println(Arrays.toString(massConstruct));
    }
    private void deleteElement(String value){
        for (int i = 0; i <flag ; i++) {
            if(massConstruct[i].equals(value)) {
                deleteElement(i);
                i--;
            }
        }
    }

    @Override
    public boolean add(int index, String value) throws Exception {
        if (index>flag+1||index<0){
            throw new Exception("Sorry you cant use index " + index + " Size: " + (flag+1));
        }
        incrSizeMassFilling();
        addByIndex(index, value);
        return true;
    }

    @Override
    public boolean add(String value) {
        incrSizeMassFilling();
        if(flag!=0) {
            massConstruct[flag+1] = value;
            flag++;
            System.out.println(Arrays.toString(massConstruct));
            return true;
        }
        if(flag==0&&isEmpty==true) {
            massConstruct[0] = value;
            isEmpty = false;
            System.out.println(Arrays.toString(massConstruct));
            return true;
        }
            massConstruct[flag+1] = value;
            flag++;
            System.out.println(Arrays.toString(massConstruct));
        return true;
    }
    @Override
    public boolean delete(int index) throws Exception {
        if (index>flag+1||index<0){
            throw new Exception("Sorry you cant use index " + index + " Size: " + (flag+1));
        }
        if (flag == 0&&isEmpty==true){
            throw new Exception("Sorry Collection is empty");
        }
        deleteElement(index);
        decrSizeMassFilling();
        return true;
    }
    @Override
    public boolean delete(String value) {
        deleteElement(value);
        decrSizeMassFilling();
        return false;
    }
    @Override
    public String get(int index) throws Exception {
        if (index>flag||index<0) throw new Exception("out of range collection Index " + index + " Size " + (flag+1));

        return massConstruct[index];
    }
}



