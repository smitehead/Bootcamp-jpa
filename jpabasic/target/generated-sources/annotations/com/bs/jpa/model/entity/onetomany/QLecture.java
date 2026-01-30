package com.bs.jpa.model.entity.onetomany;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLecture is a Querydsl query type for Lecture
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLecture extends EntityPathBase<Lecture> {

    private static final long serialVersionUID = 1831042317L;

    public static final QLecture lecture = new QLecture("lecture");

    public final StringPath lectureClass = createString("lectureClass");

    public final StringPath lectureName = createString("lectureName");

    public final NumberPath<Long> lectureNo = createNumber("lectureNo", Long.class);

    public final StringPath lectureRoom = createString("lectureRoom");

    public final ListPath<Student, QStudent> st = this.<Student, QStudent>createList("st", Student.class, QStudent.class, PathInits.DIRECT2);

    public QLecture(String variable) {
        super(Lecture.class, forVariable(variable));
    }

    public QLecture(Path<? extends Lecture> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLecture(PathMetadata metadata) {
        super(Lecture.class, metadata);
    }

}

