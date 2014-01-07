package interfaces;

import java.util.List;

import kernel.Comment;
import kernel.Users;

public interface CommentEJBRemote {
	List<Comment> findComment();
	Comment findCommentById(int id);
	Comment findCommentByUser(int id);
	Comment createComment(Comment comment);
	Comment deleteComment(Comment comment);
	Comment updateComment(Comment comment);
	List<Users> findUsersByComment(int id);
}
