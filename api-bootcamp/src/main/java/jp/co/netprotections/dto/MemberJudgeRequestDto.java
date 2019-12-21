package jp.co.netprotections.dto;

import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.netprotections.common.entity.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author t.miyazawa
 *　入隊候補者の一覧が格納されるDTO
 */
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberJudgeRequestDto {
	private List<Candidate> memberCandidateList;

}
