package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본생성자를 아무곳에서나 생성하지 못하게 하기위함
@ToString(of = {"id", "username", "age"}) // toString 에 team을 넣으면 왔다갔다 하면서 무한루프 가능성..
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id") //외래키명으로 잡힘
    private Team team;

    public Member(String username) {
        this(username, 0, null);
    }

    public Member(String username, int age) {
        this(username, age, null);
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }





}
