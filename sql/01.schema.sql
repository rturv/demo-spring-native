CREATE TABLE libros (
    id_libro SERIAL PRIMARY KEY,
    cd_codigo text not null,
    ds_titulo TEXT NOT NULL,
    ds_autor TEXT NOT null,
    txt_sinopsis text not NULL
);

CREATE unique INDEX libros_i1 ON public.libros USING btree (cd_codigo);
CREATE INDEX libros_i2 ON public.libros USING btree (ds_titulo);
