package ssafy.com.person.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ssafy.com.person.dto.Person;

public class PersonManager {
	static List<Person> list;
	
	static PersonManager instance = new PersonManager();
	
	private PersonManager() {
		list = new ArrayList<>();
	}
	
	static public PersonManager getInstance() {
		return instance;
	}
	
	/* 목록을 조회 */
	public Person[] getPersonList() {
		return list.toArray(new Person[list.size()]);
	}
	
	/* 번호에 해당하는 사람을 조회 */
	public Person getPerson(int no) {
		if (list.size() == 0) return null;
		
		Iterator<Person> it = list.iterator();
		while (it.hasNext()) {
			Person p = it.next();
			if (p.getNo() == no) return p; 
		}
		return null;
	}
	
	/* 사람을 추가 */
	public void add(Person p) {
		Iterator<Person> it = list.iterator();
		while (it.hasNext()) {
			Person p2 = it.next();
			if (p2.getNo() == p.getNo()) return;
		}
		list.add(p);
	}
	
	/* 사람을 수정 */
	public void update(Person p) {
		for (Person person:list) {
			if (person.getNo() == p.getNo()) {
				person.setAge(p.getAge());
				person.setMsg(p.getMsg());
				person.setName(p.getName());
			}
		}
	}
	
	public void delete(int no) {
		Person p = getPerson(no);
		list.remove(p);
	}
}
