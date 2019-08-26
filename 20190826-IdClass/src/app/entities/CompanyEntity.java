package app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name="company")
public class CompanyEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int    id;
	@Column(length=100)
	private String companyName;
	@OneToMany(mappedBy="company", cascade=CascadeType.ALL)
	private Set<EmployeeEntity> employees = new HashSet<>();
	
	public CompanyEntity(String companyName) {
		super();
		this.companyName = companyName;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyEntity other = (CompanyEntity) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
}
