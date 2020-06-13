package wangy.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangy.mall.dao.CommentRepository;
import wangy.mall.entity.Comment;
import wangy.mall.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> queryAllComments(int goodsId) {
        return commentRepository.findByGoodsId(goodsId);
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }
}
