package model;



public class Labortories {
	private int tid;
	   
	private String testName;
    private int price;
   

    // Constructor
    public Labortories (int tid,String testName, int price) {
    	this.tid = tid;
        this.testName = testName;
        this.price = price;
        
    }

    public Labortories() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public int gettid() {
        return tid;
    }

    public void settid(int tid) {
        this.tid=  tid;
    }
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getCost() {
        return price;
    }

    public void setCost(int price) {
        this.price =price;
    }

    
    @Override
    public String toString() {
        return "Labortories{" +
        		 ",tid='" +tid + '\'' +
                "testName='" + testName + '\'' +
                ",price='" +price + '\'' +
                '}';
    }

}
