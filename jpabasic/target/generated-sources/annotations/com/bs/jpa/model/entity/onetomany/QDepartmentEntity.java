package com.bs.jpa.model.entity.onetomany;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDepartmentEntity is a Querydsl query type for DepartmentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepartmentEntity extends EntityPathBase<DepartmentEntity> {

    private static final long serialVersionUID = -247107802L;

    public static final QDepartmentEntity departmentEntity = new QDepartmentEntity("departmentEntity");

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Long> deptNo = createNumber("deptNo", Long.class);

    public final ListPath<EmployeeEntity, QEmployeeEntity> employees = this.<EmployeeEntity, QEmployeeEntity>createList("employees", EmployeeEntity.class, QEmployeeEntity.class, PathInits.DIRECT2);

    public final EnumPath<com.bs.jpa.common.Local> localName = createEnum("localName", com.bs.jpa.common.Local.class);

    public QDepartmentEntity(String variable) {
        super(DepartmentEntity.class, forVariable(variable));
    }

    public QDepartmentEntity(Path<? extends DepartmentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDepartmentEntity(PathMetadata metadata) {
        super(DepartmentEntity.class, metadata);
    }

}

