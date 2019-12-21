package jp.co.netprotections.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.netprotections.common.MessageDefine;
import jp.co.netprotections.common.entity.Candidate;
import jp.co.netprotections.common.service.CommonMemberJudgeService;

public class CommonMemberJudgeServiceImpl implements CommonMemberJudgeService  {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonMemberJudgeServiceImpl.class);

	@Override
	public boolean isCandidateExceededEnlistmentRequirements (Candidate candidate) {
		// 名前が正しいか判定
		if (this.isNameValid(candidate.getMemberName()) && this.isEachAblityInRange(candidate) && this.checkCandidateAblity(candidate)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 候補者の能力値が入隊に条件を超えているかチェックする
	 * @param candidate
	 * @return boolean 入隊可否
	 */
	private boolean checkCandidateAblity(Candidate candidate) {
		// cogitationとcoodinationの得点が1点以下であるかを判定
		if (candidate.getCogitation() <= 1) {
			LOGGER.info(MessageDefine.SCORE_UNDER_ONE, "cogitation or coodinataion");
			return false;
		}
		if (candidate.getCoodination() <= 1) {
			LOGGER.info(MessageDefine.SCORE_UNDER_ONE, "cogitation or coodinataion");
			return false;
		}
		// 能力の合計値が10以上かどうかを判定
		if ((candidate.getEventPlanning() + candidate.getCogitation() + candidate.getCoodination()
		+ candidate.getProgrammingAbility() + candidate.getInfrastructureKnowledge()) <= 10) {
			LOGGER.info(MessageDefine.TOTALSCORE_NOT_REACH, candidate.getMemberName());
			return false;
		}
		return false;
	}
	
	/**
	 * 候補者の名前に不正がないかチェックする
	 * @param name
	 * @return　boolean 候補者の名前に不正がないかかどうか
	 */
	private boolean isNameValid(String name) {
			if(name.equals(null) || name.contentEquals("")) {
				LOGGER.info(MessageDefine.NULL_NAME);
				return false;
			} else {
				return true;
			}
	}
	
	/**
	 * それぞれの能力数値が1-5の間にあるかチェックする
	 * @param candidate
	 * @return boolean 隊員の能力が指定された範囲にあるかどうか
	 */
	private boolean isEachAblityInRange (Candidate candidate) {
		List<Integer> parameterList = new ArrayList<Integer>();
		parameterList.add(candidate.getCogitation());
		parameterList.add(candidate.getCoodination());
		parameterList.add(candidate.getEventPlanning());
		parameterList.add(candidate.getInfrastructureKnowledge());
		parameterList.add(candidate.getProgrammingAbility());
		for (int eachParam : parameterList) {
			if (eachParam <= 0 || eachParam > 5) {
				LOGGER.info(MessageDefine.EACH_PARAMETER_ERROR);
				return false;
			}
		}
		return true;
	}
	
}
