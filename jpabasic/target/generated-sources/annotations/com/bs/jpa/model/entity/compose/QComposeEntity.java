package com.bs.jpa.model.entity.compose;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QComposeEntity is a Querydsl query type for ComposeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComposeEntity extends EntityPathBase<ComposeEntity> {

    private static final long serialVersionUID = 816998518L;

    public static final QComposeEntity composeEntity = new QComposeEntity("composeEntity");

    public final StringPath content = createString("content");

    public final NumberPath<Long> firstId = createNumber("firstId", Long.class);

    public final NumberPath<Long> secondId = createNumber("secondId", Long.class);

    public QComposeEntity(String variable) {
        super(ComposeEntity.class, forVariable(variable));
    }

    public QComposeEntity(Path<? extends ComposeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComposeEntity(PathMetadata metadata) {
        super(ComposeEntity.class, metadata);
    }

}

