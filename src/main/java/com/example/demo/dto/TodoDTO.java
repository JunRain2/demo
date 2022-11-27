package com.example.demo.dto;

import com.example.demo.model.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {//보안상 userID를 숨키는게 적절.
    private String id;
    private String title;
    private boolean done;

    public TodoDTO(final TodoEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }

    public static TodoEntity toEntity(final TodoDTO dto) {
        return TodoEntity.builder()//생성자와 같은 역활, 빌더를 생성하는 메서드의 이름은 기본 값인 builder()
                .id(dto.getId())//id에 dtd.getId()를 입력.
                .title(dto.getTitle())//title에 dto.getTitle 입력
                .done(dto.isDone())// done에 dto.isDone() 입력
                .build();//builder()로 얻은 빌더에 필드 값들을 입력하고 마지막에 객체를 생성하는 동작인 빌드 메서드의 이름을 네이밍 할 수 있는 어노테이션 값이다.
    }
}
