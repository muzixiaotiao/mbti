/**
 * MBTI性格测试系统.
**/

package com.mbti.common.validator.group;

import javax.validation.GroupSequence;

/**
 * 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
** @author *
 */
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {

}
