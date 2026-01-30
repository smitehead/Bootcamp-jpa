package com.bs.jpa.model.entity.workshop;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLesson1 is a Querydsl query type for Lesson1
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLesson1 extends EntityPathBase<Lesson1> {

    private static final long serialVersionUID = -1374863755L;

    public static final QLesson1 lesson1 = new QLesson1("lesson1");

    public final StringPath lessonName = createString("lessonName");

    public final NumberPath<Long> lessonNo = createNumber("lessonNo", Long.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final ListPath<Buket, QBuket> student = this.<Buket, QBuket>createList("student", Buket.class, QBuket.class, PathInits.DIRECT2);

    public QLesson1(String variable) {
        super(Lesson1.class, forVariable(variable));
    }

    public QLesson1(Path<? extends Lesson1> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLesson1(PathMetadata metadata) {
        super(Lesson1.class, metadata);
    }

}

