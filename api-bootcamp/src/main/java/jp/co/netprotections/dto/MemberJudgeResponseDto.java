package jp.co.netprotections.dto;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author t.miyazawa
 *　入隊判定結果一覧が格納されるDTO
 */
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberJudgeResponseDto {
	private List<CandidateJudgedResultDto> result;

}
