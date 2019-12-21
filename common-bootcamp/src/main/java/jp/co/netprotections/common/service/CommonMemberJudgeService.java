package jp.co.netprotections.common.service;

import jp.co.netprotections.common.entity.Candidate;

/**
 * @author t.miyazawa
 * 入退社可否判定を行うサービス
 */
public interface CommonMemberJudgeService {
	/**
	 * 一人一人の候補者の入退可否を判定するメソッド
	 * @param candidate
	 * @return boolean 入退可否結果。
	 */
	public boolean isCandidateExceededEnlistmentRequirements(Candidate candidate);

}
