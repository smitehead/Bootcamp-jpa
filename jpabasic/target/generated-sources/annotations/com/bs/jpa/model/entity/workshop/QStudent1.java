package com.bs.jpa.model.entity.workshop;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudent1 is a Querydsl query type for Student1
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudent1 extends EntityPathBase<Student1> {

    private static final long serialVersionUID = 114430042L;

    public static final QStudent1 student1 = new QStudent1("student1");

    public final NumberPath<Integer> classNum = createNumber("classNum", Integer.class);

    public final EnumPath<com.bs.jpa.common.Gender> gender = createEnum("gender", com.bs.jpa.common.Gender.class);

    public final NumberPath<Integer> grade = createNumber("grade", Integer.class);

    public final ListPath<Buket, QBuket> lesson = this.<Buket, QBuket>createList("lesson", Buket.class, QBuket.class, PathInits.DIRECT2);

    public final NumberPath<Integer> numberSt = createNumber("numberSt", Integer.class);

    public final StringPath studentName = createString("studentName");

    public final NumberPath<Long> studentNo = createNumber("studentNo", Long.class);

    public QStudent1(String variable) {
        super(Student1.class, forVariable(variable));
    }

    public QStudent1(Path<? extends Student1> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudent1(PathMetadata metadata) {
        super(Student1.class, metadata);
    }

}

