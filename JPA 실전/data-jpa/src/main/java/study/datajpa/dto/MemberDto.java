package study.datajpa.dto;

import lombok.Data;

@Data//엔티티에 @data를 쓰는건 위험함 getter setter쓰는 거라
public class MemberDto {

    private Long id;
    private String username;
    private String teamName;

    public MemberDto(Long id, String username, String teamName) {
        this.id = id;
        this.username = username;
        this.teamName = teamName;
    }
}
