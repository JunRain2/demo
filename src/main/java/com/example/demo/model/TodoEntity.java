package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor//매개변수가 없는 생성자
@AllArgsConstructor//모든 멤버변수를 매개변소로 받은 생성자.
@Data
@Entity
@Table(name = "Todo")
public class TodoEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;// 오브젝트 아이디
    private String userId;// 이 오브젝트를 생성한 유저의 아이디
    private String title;// Todo 타이틀 예) 운동하기
    private boolean done;// true - todo를 완료한 경우(checked)
}
