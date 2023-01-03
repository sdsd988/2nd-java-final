package com.udemy.javafinal.domain.enrolment.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrolmentRequestDto {

    private Long memberId;

    private Long lectureId;
}
