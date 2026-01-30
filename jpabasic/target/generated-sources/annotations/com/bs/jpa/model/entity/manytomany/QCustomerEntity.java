package com.bs.jpa.model.entity.manytomany;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomerEntity is a Querydsl query type for CustomerEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomerEntity extends EntityPathBase<CustomerEntity> {

    private static final long serialVersionUID = -1240055053L;

    public static final QCustomerEntity customerEntity = new QCustomerEntity("customerEntity");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath customerName = createString("customerName");

    public final NumberPath<Long> customerNo = createNumber("customerNo", Long.class);

    public final EnumPath<com.bs.jpa.common.Gender> gender = createEnum("gender", com.bs.jpa.common.Gender.class);

    public final ListPath<CartEntity, QCartEntity> products = this.<CartEntity, QCartEntity>createList("products", CartEntity.class, QCartEntity.class, PathInits.DIRECT2);

    public QCustomerEntity(String variable) {
        super(CustomerEntity.class, forVariable(variable));
    }

    public QCustomerEntity(Path<? extends CustomerEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomerEntity(PathMetadata metadata) {
        super(CustomerEntity.class, metadata);
    }

}

