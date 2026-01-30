package com.bs.jpa.model.entity.onetomany;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLessonBs is a Querydsl query type for LessonBs
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLessonBs extends EntityPathBase<LessonBs> {

    private static final long serialVersionUID = 1384696314L;

    public static final QLessonBs lessonBs = new QLessonBs("lessonBs");

    public final StringPath lessonContent = createString("lessonContent");

    public final NumberPath<Long> lessonNo = createNumber("lessonNo", Long.class);

    public final StringPath lessonTitle = createString("lessonTitle");

    public final StringPath location = createString("location");

    public final ListPath<StudentBS, QStudentBS> students = this.<StudentBS, QStudentBS>createList("students", StudentBS.class, QStudentBS.class, PathInits.DIRECT2);

    public QLessonBs(String variable) {
        super(LessonBs.class, forVariable(variable));
    }

    public QLessonBs(Path<? extends LessonBs> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLessonBs(PathMetadata metadata) {
        super(LessonBs.class, metadata);
    }

}

