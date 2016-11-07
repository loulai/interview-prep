
class Dummy {
	
	public static void main(String[] args){
		Dummy myDummy = new Dummy("Bob");
	}

	private String name;

    public void Dummy() {}

    public void Dummy(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
