package com.bs.jpa.model.entity.onetomany;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudentBS is a Querydsl query type for StudentBS
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudentBS extends EntityPathBase<StudentBS> {

    private static final long serialVersionUID = 1917366171L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudentBS studentBS = new QStudentBS("studentBS");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Integer> grade = createNumber("grade", Integer.class);

    public final QLessonBs lesson;

    public final StringPath name = createString("name");

    public final NumberPath<Long> studentNo = createNumber("studentNo", Long.class);

    public QStudentBS(String variable) {
        this(StudentBS.class, forVariable(variable), INITS);
    }

    public QStudentBS(Path<? extends StudentBS> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudentBS(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudentBS(PathMetadata metadata, PathInits inits) {
        this(StudentBS.class, metadata, inits);
    }

    public QStudentBS(Class<? extends StudentBS> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lesson = inits.isInitialized("lesson") ? new QLessonBs(forProperty("lesson")) : null;
    }

}

