package com.teamA.hicardi.domain.faq.entity;

import com.teamA.hicardi.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Faq extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String question;

    private String answer;

    @Builder
    public Faq(Category category, String question, String answer) {
        this.category = category;
        this.question = question;
        this.answer = answer;
    }
}
