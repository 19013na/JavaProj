package workshop.person.entity;

public class PersonEntity {
	private String name;
	private char gender;
	private String ssn;
	private String address;
	private String phone;
	
	// 생성자
	public PersonEntity() {
		super();
	}
	
	public PersonEntity(String name, String ssn, String address, String phone) {
		setName(name);
		setSsn(ssn);
		setAddress(address);
		setPhone(phone);
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
		if (ssn.charAt(6) == '1' || ssn.charAt(6) == '3') {
			gender = '남';
		} else if (ssn.charAt(6) == '2' || ssn.charAt(6) == '4') {
			gender = '여';
		} else {
			System.out.println("부정확한 정보 입력");
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	
	
}
