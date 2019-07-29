package hello.beans.DAO.noSql;

import javax.persistence.Id;

public class Student {

	@Id
    public String id;

    public String name;
    public String course;
	
	public Student(String name, String course) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.course = course;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
    public String toString() {
        return String.format(
                "Student[id=%s, name='%s', course='%s']",
                id, name, course);
    }
	
}
