package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class UserEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id; // 유저에게 고유하게 부여되는 id

    @Column(nullable = false)
    private String username; // 아이디로 사용할 유저 네임. 이메일 or 그냥 문자열

    private String password; // 패스워드. null이 가능한 이유는 나중에 SSO로 구형할 것이기 때문. 회원가입 구현하는 컨트롤러에서 반드시 password를 입력하게 할 수 있다.

    private String role; // 사용자의 롤. 예 : 어드민, 일반사용자

    private String authProvider; // 이후 OAuth에서 사용할 유저 정보 제공자 : github
}
