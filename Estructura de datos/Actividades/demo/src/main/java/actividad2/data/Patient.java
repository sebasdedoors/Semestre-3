package actividad2.data;

public class Patient {
    private String name;
    private int id;
    private String sick;
    private int priority;

    public Patient(String name, int id, String sick, int priority){
        setName(name);
        setId(id);
        setSick(sick);
        setPriority(priority);
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public String getSick(){
        return sick;
    }

    public int getPriority(){
        return priority;
    }

    public void setName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Este campo no puede estar vaacio.");
        }
        this.name = name;
    }

    public void setId(int id){
        if(id <= 0){
            throw new IllegalArgumentException("El ID debe ser  un número positivo.");
        }
        this.id = id;
    }

    public void setSick(String sick){
        if(sick == null || sick.trim().isEmpty()){
            throw new IllegalArgumentException("Este campo no puede estar vacio.");
        }
        this.sick = sick;
    }

    public void setPriority(int priority){
        if(priority < 1 || priority > 3){
            throw new IllegalArgumentException("El nivel de prioridad debe estar entre 1 y 3.");
        }
        this.priority = priority;
    }
}
