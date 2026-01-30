package com.bs.jpa.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWebMemberEntity is a Querydsl query type for WebMemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWebMemberEntity extends EntityPathBase<WebMemberEntity> {

    private static final long serialVersionUID = 391301646L;

    public static final QWebMemberEntity webMemberEntity = new QWebMemberEntity("webMemberEntity");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final ListPath<com.bs.jpa.jpql.model.entity.BoardEntity, com.bs.jpa.jpql.model.entity.QBoardEntity> boards = this.<com.bs.jpa.jpql.model.entity.BoardEntity, com.bs.jpa.jpql.model.entity.QBoardEntity>createList("boards", com.bs.jpa.jpql.model.entity.BoardEntity.class, com.bs.jpa.jpql.model.entity.QBoardEntity.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final DatePath<java.sql.Date> enrollDate = createDate("enrollDate", java.sql.Date.class);

    public final StringPath gender = createString("gender");

    public final StringPath hobby = createString("hobby");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final StringPath userId = createString("userId");

    public final StringPath userName = createString("userName");

    public QWebMemberEntity(String variable) {
        super(WebMemberEntity.class, forVariable(variable));
    }

    public QWebMemberEntity(Path<? extends WebMemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWebMemberEntity(PathMetadata metadata) {
        super(WebMemberEntity.class, metadata);
    }

}

