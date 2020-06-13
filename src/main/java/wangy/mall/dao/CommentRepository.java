package wangy.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wangy.mall.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByGoodsId(int goodsId);
}
