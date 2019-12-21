package jp.co.netprotections.service;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;


public interface MemberJudgeService {
	/**
	 * 複数人の候補者を判定するメソッド
	 * @param candidates
	 * @return 各候補者の判定結果
	 */
	public abstract MemberJudgeResponseDto judgeCanidates(MemberJudgeRequestDto candidates);
	
}
