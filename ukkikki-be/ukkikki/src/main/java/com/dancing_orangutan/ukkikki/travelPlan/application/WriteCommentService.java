package com.dancing_orangutan.ukkikki.travelPlan.application;

import com.dancing_orangutan.ukkikki.travelPlan.application.command.WriteCommentCommand;

public interface WriteCommentService {

	void writeComment(WriteCommentCommand command);

}
