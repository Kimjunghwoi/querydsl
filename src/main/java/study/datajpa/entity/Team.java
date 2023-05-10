package study.datajpa.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA는 기본생성자가 필요..
@ToString(of = {"id", "name"})
public class Team {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team") // mappedBy == 연관관계 주인이 아니다..
    private List<Member> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

}
