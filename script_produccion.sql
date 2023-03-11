-- This script was generated by the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE IF NOT EXISTS public.venta
(
    id bigserial NOT NULL,
    fecha date NOT NULL,
    hora time without time zone NOT NULL,
    total numeric(9, 2) NOT NULL,
    total_ganancia numeric(9, 2) NOT NULL,
    tipo integer NOT NULL,
    estado integer NOT NULL,
    saldo numeric(9, 2),
    id_cliente bigint NOT NULL,
    id_usuario bigint NOT NULL,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.venta
    IS 'tipo:
contado = 1
credito = 2

estado:
realizada = 1
cancelada = 0

saldo:
puede ser null por se usa cuando es una venta al credito';

CREATE TABLE IF NOT EXISTS public.detalle_venta
(
    id bigserial NOT NULL,
    cantidad integer NOT NULL,
    precio_costo numeric(9, 2) NOT NULL,
    precio_unitario numeric(9, 2) NOT NULL,
    sub_total numeric(9, 2) NOT NULL,
    total_ganancia numeric(9, 2) NOT NULL,
    estado integer NOT NULL,
    id_venta bigint NOT NULL,
    id_producto bigint NOT NULL,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.detalle_venta
    IS 'estado:
realizada = 1
cancelada = 0';

CREATE TABLE IF NOT EXISTS public.cliente
(
    id bigserial NOT NULL,
    nit character varying(15) NOT NULL,
    nombre_completo character varying(100) NOT NULL,
    direccion character varying(100) NOT NULL,
    telefono character varying(10),
    limite_credito numeric(9, 2) NOT NULL,
    estado integer NOT NULL,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.cliente
    IS 'estado:
1 = activo
0 = eliminado';

CREATE TABLE IF NOT EXISTS public.cuenta_cliente
(
    id bigserial NOT NULL,
    fecha date NOT NULL,
    comentario character varying(100),
    cargo numeric(9, 2) NOT NULL,
    abono numeric(9, 2) NOT NULL,
    saldo numeric(9, 2) NOT NULL,
    estado integer NOT NULL,
    id_venta bigint NOT NULL,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.cuenta_cliente
    IS 'estado:
1 = activo
0 = eliminado';

CREATE TABLE IF NOT EXISTS public.abono_cliente
(
    id bigserial NOT NULL,
    monto numeric(9, 2) NOT NULL,
    documento character varying(50),
    fecha date NOT NULL,
    id_venta bigint NOT NULL,
    estado integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.empresa
(
    id serial NOT NULL,
    nombre character varying(80) NOT NULL,
    direccion character varying(100) NOT NULL,
    telefono character varying(10) NOT NULL,
    logo character varying(150) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.categoria
(
    id bigserial NOT NULL,
    descripcion character varying(50) NOT NULL,
    estado integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.marca
(
    id bigserial NOT NULL,
    descripcion character varying(50) NOT NULL,
    estado integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.producto
(
    id bigserial NOT NULL,
    descripcion character varying(100) NOT NULL,
    existencia integer NOT NULL,
    precio_compra numeric(9, 2) NOT NULL,
    precio_venta numeric(9, 2) NOT NULL,
    ganancia_unitaria numeric(9, 2) NOT NULL,
    estado integer NOT NULL,
    id_marca bigint NOT NULL,
    id_categoria bigint NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.kardex
(
    id bigserial NOT NULL,
    fecha date NOT NULL,
    hora time without time zone NOT NULL,
    concepto character varying(100) NOT NULL,
    existencia_anterior integer NOT NULL,
    tipo integer NOT NULL,
    cantidad integer NOT NULL,
    existencia_posterior integer NOT NULL,
    id_producto bigint NOT NULL,
    id_usuario bigint NOT NULL,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.kardex
    IS 'tipo:
1 = entrada
2 = salida
3 = ajuste
4 = devolucion';

CREATE TABLE IF NOT EXISTS public.codigo_producto
(
    id bigserial NOT NULL,
    codigo character varying(50) NOT NULL,
    estado integer NOT NULL,
    id_producto bigint NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.compra
(
    id bigserial NOT NULL,
    fecha date NOT NULL,
    hora time without time zone NOT NULL,
    documento character varying(45) NOT NULL,
    total numeric(9, 2) NOT NULL,
    estado integer NOT NULL,
    tipo integer NOT NULL,
    saldo numeric(9, 2),
    id_proveedor bigint NOT NULL,
    id_usuario bigint NOT NULL,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.compra
    IS 'tipo:
contado = 1
credito = 2

estado:
realizada = 1
cancelada = 0

saldo:
puede ser null, porque se usa si la compra es al crédito';

CREATE TABLE IF NOT EXISTS public.proveedor
(
    id bigserial NOT NULL,
    nit character varying(15) NOT NULL,
    nombre character varying(100) NOT NULL,
    direccion character varying(100) NOT NULL,
    telefono character varying(10),
    estado integer,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.proveedor
    IS 'estado:
1 = activo
0 = eliminado';

CREATE TABLE IF NOT EXISTS public.cuenta_proveedor
(
    id bigserial NOT NULL,
    fecha date NOT NULL,
    comentario character varying(100),
    cargo numeric(9, 2) NOT NULL,
    abono numeric(9, 2) NOT NULL,
    saldo numeric(9, 2) NOT NULL,
    estado integer NOT NULL,
    id_compra bigint NOT NULL,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.cuenta_proveedor
    IS 'estado:
1 = activo
0 = eliminado';

CREATE TABLE IF NOT EXISTS public.abono_proveedor
(
    id bigserial NOT NULL,
    monto numeric(9, 2) NOT NULL,
    documento character varying(50),
    fecha date NOT NULL,
    id_compra bigint NOT NULL,
    estado integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.detalle_compra
(
    id bigserial NOT NULL,
    cantidad integer NOT NULL,
    precio_costo numeric(9, 2) NOT NULL,
    sub_total numeric(9, 2) NOT NULL,
    estado integer NOT NULL,
    id_compra bigint NOT NULL,
    id_producto bigint NOT NULL,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.detalle_compra
    IS 'estado:
realizada = 1
cancelada = 0';

CREATE TABLE IF NOT EXISTS public.usuario
(
    id bigserial NOT NULL,
    nombre character varying(50) NOT NULL,
    "user" character varying(30) NOT NULL,
    password character varying(150) NOT NULL,
    estado integer NOT NULL,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.usuario
    IS 'estado:
activo = 1
eliminado = 0';

CREATE TABLE IF NOT EXISTS public.flujo_inventario
(
    id bigserial NOT NULL,
    fecha date NOT NULL,
    concepto character varying(100) NOT NULL,
    cantidad integer NOT NULL,
    tipo integer NOT NULL,
    estado integer NOT NULL,
    id_producto bigint NOT NULL,
    id_usuario bigint NOT NULL,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.flujo_inventario
    IS 'tipo:
1 = agregar inventario
2 = sacar inventario

estado:
activo = 1
anulado = 0';

ALTER TABLE IF EXISTS public.venta
    ADD FOREIGN KEY (id_cliente)
    REFERENCES public.cliente (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.venta
    ADD FOREIGN KEY (id_usuario)
    REFERENCES public.usuario (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.detalle_venta
    ADD FOREIGN KEY (id_producto)
    REFERENCES public.producto (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.detalle_venta
    ADD FOREIGN KEY (id_venta)
    REFERENCES public.venta (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.cuenta_cliente
    ADD FOREIGN KEY (id_venta)
    REFERENCES public.venta (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.abono_cliente
    ADD FOREIGN KEY (id_venta)
    REFERENCES public.venta (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.producto
    ADD FOREIGN KEY (id_marca)
    REFERENCES public.marca (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.producto
    ADD FOREIGN KEY (id_categoria)
    REFERENCES public.categoria (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.kardex
    ADD FOREIGN KEY (id_producto)
    REFERENCES public.producto (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.kardex
    ADD FOREIGN KEY (id_usuario)
    REFERENCES public.usuario (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.codigo_producto
    ADD FOREIGN KEY (id_producto)
    REFERENCES public.producto (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.compra
    ADD FOREIGN KEY (id_proveedor)
    REFERENCES public.proveedor (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.compra
    ADD FOREIGN KEY (id_usuario)
    REFERENCES public.usuario (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.cuenta_proveedor
    ADD FOREIGN KEY (id_compra)
    REFERENCES public.compra (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.abono_proveedor
    ADD FOREIGN KEY (id_compra)
    REFERENCES public.compra (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.detalle_compra
    ADD FOREIGN KEY (id_compra)
    REFERENCES public.compra (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.detalle_compra
    ADD FOREIGN KEY (id_producto)
    REFERENCES public.producto (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.flujo_inventario
    ADD FOREIGN KEY (id_producto)
    REFERENCES public.producto (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.flujo_inventario
    ADD FOREIGN KEY (id_usuario)
    REFERENCES public.usuario (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

END;