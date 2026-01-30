package com.bs.jpa.model.entity.workshop;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBuket is a Querydsl query type for Buket
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBuket extends EntityPathBase<Buket> {

    private static final long serialVersionUID = 1419968675L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBuket buket = new QBuket("buket");

    public final QLesson1 lesson;

    public final NumberPath<Integer> semester = createNumber("semester", Integer.class);

    public final QStudent1 student;

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QBuket(String variable) {
        this(Buket.class, forVariable(variable), INITS);
    }

    public QBuket(Path<? extends Buket> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBuket(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBuket(PathMetadata metadata, PathInits inits) {
        this(Buket.class, metadata, inits);
    }

    public QBuket(Class<? extends Buket> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lesson = inits.isInitialized("lesson") ? new QLesson1(forProperty("lesson")) : null;
        this.student = inits.isInitialized("student") ? new QStudent1(forProperty("student")) : null;
    }

}

