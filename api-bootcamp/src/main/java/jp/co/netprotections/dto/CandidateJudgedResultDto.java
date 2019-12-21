package jp.co.netprotections.dto;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author t.miyazawa
 *　候補者一人一人の入退社判定結果を格納するDTO
 */
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateJudgedResultDto {
	private String memberName;
	private boolean enlistedPropriety;

}
