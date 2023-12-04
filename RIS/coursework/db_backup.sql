PGDMP         4                {            rental_car_system    15.2    15.2 G    [           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            \           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ]           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ^           1262    16538    rental_car_system    DATABASE     �   CREATE DATABASE rental_car_system WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
 !   DROP DATABASE rental_car_system;
                vlad    false            �            1259    16703    bookings    TABLE     �   CREATE TABLE public.bookings (
    id integer NOT NULL,
    pickup_date date,
    drop_date date,
    status character varying(50),
    car_id integer,
    price double precision,
    client_id integer
);
    DROP TABLE public.bookings;
       public         heap    vlad    false            �            1259    16702    bookings_id_seq    SEQUENCE     �   ALTER TABLE public.bookings ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.bookings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          vlad    false    233            �            1259    16590    brands    TABLE     h   CREATE TABLE public.brands (
    id integer NOT NULL,
    brand_name character varying(100) NOT NULL
);
    DROP TABLE public.brands;
       public         heap    vlad    false            �            1259    16589    brands_id_seq    SEQUENCE     �   ALTER TABLE public.brands ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.brands_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          vlad    false    218            �            1259    16584    cars    TABLE     �  CREATE TABLE public.cars (
    id integer NOT NULL,
    model_id integer NOT NULL,
    vehicle_type_id integer NOT NULL,
    transmission_id integer NOT NULL,
    aircon boolean NOT NULL,
    engine_id integer NOT NULL,
    performance integer NOT NULL,
    capacity integer NOT NULL,
    trunk_volume_id integer NOT NULL,
    fuel_consumption double precision NOT NULL,
    price_per_day integer NOT NULL,
    year integer NOT NULL,
    mileage integer NOT NULL,
    plate_num integer NOT NULL
);
    DROP TABLE public.cars;
       public         heap    vlad    false            �            1259    16612    cars_id_seq    SEQUENCE     �   ALTER TABLE public.cars ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.cars_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          vlad    false    216            �            1259    16544    clients    TABLE     �   CREATE TABLE public.clients (
    id integer NOT NULL,
    age integer NOT NULL,
    driving_exp integer NOT NULL,
    address character varying(100) NOT NULL,
    user_id integer,
    passport character varying(100) NOT NULL
);
    DROP TABLE public.clients;
       public         heap    vlad    false            �            1259    16609    clients_id_seq    SEQUENCE     �   ALTER TABLE public.clients ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          vlad    false    215            �            1259    16626    engines    TABLE     Z   CREATE TABLE public.engines (
    id integer NOT NULL,
    type character varying(100)
);
    DROP TABLE public.engines;
       public         heap    vlad    false            �            1259    16625    engine_id_seq    SEQUENCE     �   ALTER TABLE public.engines ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.engine_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          vlad    false    229            �            1259    16598    models    TABLE     t   CREATE TABLE public.models (
    id integer NOT NULL,
    model_name character varying(50),
    brand_id integer
);
    DROP TABLE public.models;
       public         heap    vlad    false            �            1259    16597    models_id_seq    SEQUENCE     �   ALTER TABLE public.models ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.models_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          vlad    false    220            �            1259    16620    transmissions    TABLE     `   CREATE TABLE public.transmissions (
    id integer NOT NULL,
    type character varying(100)
);
 !   DROP TABLE public.transmissions;
       public         heap    vlad    false            �            1259    16619    transmissions_id_seq    SEQUENCE     �   ALTER TABLE public.transmissions ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.transmissions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          vlad    false    227            �            1259    16632    trunks    TABLE     [   CREATE TABLE public.trunks (
    id integer NOT NULL,
    volume character varying(100)
);
    DROP TABLE public.trunks;
       public         heap    vlad    false            �            1259    16631    trunks_id_seq    SEQUENCE     �   ALTER TABLE public.trunks ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.trunks_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          vlad    false    231            �            1259    16539    users    TABLE     \  CREATE TABLE public.users (
    id integer NOT NULL,
    password character varying(100) NOT NULL,
    name character varying(100) NOT NULL,
    surname character varying(100) NOT NULL,
    patronymic character varying(100),
    phone_num character varying(100) NOT NULL,
    role character varying(50) NOT NULL,
    email character varying(50)
);
    DROP TABLE public.users;
       public         heap    vlad    false            �            1259    16611    users_id_seq    SEQUENCE     �   ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          vlad    false    214            �            1259    16614    vehicle_types    TABLE     _   CREATE TABLE public.vehicle_types (
    id integer NOT NULL,
    type character varying(50)
);
 !   DROP TABLE public.vehicle_types;
       public         heap    vlad    false            �            1259    16613    vehicle_types_id_seq    SEQUENCE     �   ALTER TABLE public.vehicle_types ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.vehicle_types_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          vlad    false    225            X          0    16703    bookings 
   TABLE DATA           `   COPY public.bookings (id, pickup_date, drop_date, status, car_id, price, client_id) FROM stdin;
    public          vlad    false    233   6N       I          0    16590    brands 
   TABLE DATA           0   COPY public.brands (id, brand_name) FROM stdin;
    public          vlad    false    218   |N       G          0    16584    cars 
   TABLE DATA           �   COPY public.cars (id, model_id, vehicle_type_id, transmission_id, aircon, engine_id, performance, capacity, trunk_volume_id, fuel_consumption, price_per_day, year, mileage, plate_num) FROM stdin;
    public          vlad    false    216   �N       F          0    16544    clients 
   TABLE DATA           S   COPY public.clients (id, age, driving_exp, address, user_id, passport) FROM stdin;
    public          vlad    false    215   P       T          0    16626    engines 
   TABLE DATA           +   COPY public.engines (id, type) FROM stdin;
    public          vlad    false    229   �P       K          0    16598    models 
   TABLE DATA           :   COPY public.models (id, model_name, brand_id) FROM stdin;
    public          vlad    false    220   Q       R          0    16620    transmissions 
   TABLE DATA           1   COPY public.transmissions (id, type) FROM stdin;
    public          vlad    false    227   �Q       V          0    16632    trunks 
   TABLE DATA           ,   COPY public.trunks (id, volume) FROM stdin;
    public          vlad    false    231   �Q       E          0    16539    users 
   TABLE DATA           `   COPY public.users (id, password, name, surname, patronymic, phone_num, role, email) FROM stdin;
    public          vlad    false    214   #R       P          0    16614    vehicle_types 
   TABLE DATA           1   COPY public.vehicle_types (id, type) FROM stdin;
    public          vlad    false    225   �S       _           0    0    bookings_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.bookings_id_seq', 10, true);
          public          vlad    false    232            `           0    0    brands_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.brands_id_seq', 12, true);
          public          vlad    false    217            a           0    0    cars_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.cars_id_seq', 18, true);
          public          vlad    false    223            b           0    0    clients_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.clients_id_seq', 8, true);
          public          vlad    false    221            c           0    0    engine_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.engine_id_seq', 5, true);
          public          vlad    false    228            d           0    0    models_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.models_id_seq', 15, true);
          public          vlad    false    219            e           0    0    transmissions_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.transmissions_id_seq', 5, true);
          public          vlad    false    226            f           0    0    trunks_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.trunks_id_seq', 5, true);
          public          vlad    false    230            g           0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 9, true);
          public          vlad    false    222            h           0    0    vehicle_types_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.vehicle_types_id_seq', 9, true);
          public          vlad    false    224            �           2606    16543    users Users_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.users
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.users DROP CONSTRAINT "Users_pkey";
       public            vlad    false    214            �           2606    16707    bookings bookings_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.bookings DROP CONSTRAINT bookings_pkey;
       public            vlad    false    233            �           2606    16594    brands brands_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.brands
    ADD CONSTRAINT brands_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.brands DROP CONSTRAINT brands_pkey;
       public            vlad    false    218            �           2606    16588    cars cars_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.cars DROP CONSTRAINT cars_pkey;
       public            vlad    false    216            �           2606    16548    clients clients_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.clients DROP CONSTRAINT clients_pkey;
       public            vlad    false    215            �           2606    16630    engines engine_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.engines
    ADD CONSTRAINT engine_pkey PRIMARY KEY (id);
 =   ALTER TABLE ONLY public.engines DROP CONSTRAINT engine_pkey;
       public            vlad    false    229            �           2606    16602    models models_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.models
    ADD CONSTRAINT models_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.models DROP CONSTRAINT models_pkey;
       public            vlad    false    220            �           2606    16624     transmissions transmissions_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.transmissions
    ADD CONSTRAINT transmissions_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.transmissions DROP CONSTRAINT transmissions_pkey;
       public            vlad    false    227            �           2606    16636    trunks trunks_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.trunks
    ADD CONSTRAINT trunks_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.trunks DROP CONSTRAINT trunks_pkey;
       public            vlad    false    231            �           2606    16618     vehicle_types vehicle_types_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.vehicle_types
    ADD CONSTRAINT vehicle_types_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.vehicle_types DROP CONSTRAINT vehicle_types_pkey;
       public            vlad    false    225            �           1259    16608    fki_fk_brands    INDEX     D   CREATE INDEX fki_fk_brands ON public.models USING btree (brand_id);
 !   DROP INDEX public.fki_fk_brands;
       public            vlad    false    220            �           1259    17055    fki_fk_cars    INDEX     B   CREATE INDEX fki_fk_cars ON public.bookings USING btree (car_id);
    DROP INDEX public.fki_fk_cars;
       public            vlad    false    233            �           1259    17049    fki_fk_clients    INDEX     H   CREATE INDEX fki_fk_clients ON public.bookings USING btree (client_id);
 "   DROP INDEX public.fki_fk_clients;
       public            vlad    false    233            �           1259    16659    fki_fk_engines    INDEX     D   CREATE INDEX fki_fk_engines ON public.cars USING btree (engine_id);
 "   DROP INDEX public.fki_fk_engines;
       public            vlad    false    216            �           1259    16653    fki_fk_transmission    INDEX     O   CREATE INDEX fki_fk_transmission ON public.cars USING btree (transmission_id);
 '   DROP INDEX public.fki_fk_transmission;
       public            vlad    false    216            �           1259    16665    fki_fk_trunks    INDEX     I   CREATE INDEX fki_fk_trunks ON public.cars USING btree (trunk_volume_id);
 !   DROP INDEX public.fki_fk_trunks;
       public            vlad    false    216            �           1259    16560    fki_fk_users    INDEX     C   CREATE INDEX fki_fk_users ON public.clients USING btree (user_id);
     DROP INDEX public.fki_fk_users;
       public            vlad    false    215            �           1259    16647    fki_fk_vehicle_type    INDEX     O   CREATE INDEX fki_fk_vehicle_type ON public.cars USING btree (vehicle_type_id);
 '   DROP INDEX public.fki_fk_vehicle_type;
       public            vlad    false    216            �           2606    16603    models fk_brands    FK CONSTRAINT     {   ALTER TABLE ONLY public.models
    ADD CONSTRAINT fk_brands FOREIGN KEY (brand_id) REFERENCES public.brands(id) NOT VALID;
 :   ALTER TABLE ONLY public.models DROP CONSTRAINT fk_brands;
       public          vlad    false    3230    220    218            �           2606    17050    bookings fk_cars    FK CONSTRAINT     w   ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT fk_cars FOREIGN KEY (car_id) REFERENCES public.cars(id) NOT VALID;
 :   ALTER TABLE ONLY public.bookings DROP CONSTRAINT fk_cars;
       public          vlad    false    216    233    3224            �           2606    17044    bookings fk_clients    FK CONSTRAINT     �   ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT fk_clients FOREIGN KEY (client_id) REFERENCES public.clients(id) NOT VALID;
 =   ALTER TABLE ONLY public.bookings DROP CONSTRAINT fk_clients;
       public          vlad    false    215    3221    233            �           2606    16654    cars fk_engines    FK CONSTRAINT     |   ALTER TABLE ONLY public.cars
    ADD CONSTRAINT fk_engines FOREIGN KEY (engine_id) REFERENCES public.engines(id) NOT VALID;
 9   ALTER TABLE ONLY public.cars DROP CONSTRAINT fk_engines;
       public          vlad    false    216    229    3239            �           2606    16637    cars fk_models    FK CONSTRAINT     y   ALTER TABLE ONLY public.cars
    ADD CONSTRAINT fk_models FOREIGN KEY (model_id) REFERENCES public.models(id) NOT VALID;
 8   ALTER TABLE ONLY public.cars DROP CONSTRAINT fk_models;
       public          vlad    false    3233    220    216            �           2606    16648    cars fk_transmission    FK CONSTRAINT     �   ALTER TABLE ONLY public.cars
    ADD CONSTRAINT fk_transmission FOREIGN KEY (transmission_id) REFERENCES public.transmissions(id) NOT VALID;
 >   ALTER TABLE ONLY public.cars DROP CONSTRAINT fk_transmission;
       public          vlad    false    227    216    3237            �           2606    16660    cars fk_trunks    FK CONSTRAINT     �   ALTER TABLE ONLY public.cars
    ADD CONSTRAINT fk_trunks FOREIGN KEY (trunk_volume_id) REFERENCES public.trunks(id) NOT VALID;
 8   ALTER TABLE ONLY public.cars DROP CONSTRAINT fk_trunks;
       public          vlad    false    216    231    3241            �           2606    16555    clients fk_users    FK CONSTRAINT     y   ALTER TABLE ONLY public.clients
    ADD CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;
 :   ALTER TABLE ONLY public.clients DROP CONSTRAINT fk_users;
       public          vlad    false    214    215    3219            �           2606    16642    cars fk_vehicle_type    FK CONSTRAINT     �   ALTER TABLE ONLY public.cars
    ADD CONSTRAINT fk_vehicle_type FOREIGN KEY (vehicle_type_id) REFERENCES public.vehicle_types(id) NOT VALID;
 >   ALTER TABLE ONLY public.cars DROP CONSTRAINT fk_vehicle_type;
       public          vlad    false    216    225    3235            X   6   x���4202�50�54D0�8c�89�L9͸�*1)1�440������� ��      I   h   x�3����..OLO��2�t�/J�2�t,M��2�t��2��JL/M,���M�JI���/H��24�J�KO��/K-�24�J�K,�)�24��������� M\      G     x�5�A�!��cm0���9/���mC&AJ�T����r��\e7��b[��G��&��|d�q�&���]/t�OݲdW,�D�+B�+5dX�c�i�;�J����ɺ�H����Bv��N���a�}
̅�37�/OLJΒ�k(�=�BxT03����K��W.kPإ��_:;�ť�=z*j;iްnm+�{܊ٗ��$�C����E�n^�[:��Qe�4Э�99�W]K���9�j��5&I����o��
6t���(�h㗽*�����T�pX�      F   �   x��=
1��S�ʚM6y���]A�-<���B�
�����nd���}�̂�Iz�`ԸI'=�txc�S�y�gl�!S��Y��%G1F�:���x������+v�hT k�T�;&�~�h$�o�2d{*n�L5�pE��+��Q:�      T   ?   x�3�t�qu	�t�2��	u����t
�t�2�2L8]<]�]}�L9���}<�\�b���� �~      K   |   x��K
�0 ��F�����.�.\KS�H��߸����=��p�������y�%�%�a�)ِ�V����Z���a�Q�X��EOոcڠ�:�K���:a��"��&��6���@�B�!�      R   6   x�3��u�u��2�t��u�t�2��]]��&�~�~�\���a!\1z\\\ ��J      V   :   x�3���s��qrw���}}|��8C��!�\�`6D܄3�#���˔�#F��� E^      E   `  x�E��N�PEǗ�`|�t����)A��[ʣ@yS�#��&Ɓ3�_@$D��,$�l���^{	(̐0M�Y�;�Y�	�j�JD�rrÉ��R%'�m5��d��u㮇�r��G�?��5l��1�|�S�?��;��'
[��*�/�y�Y��iq=�To��&ƭ����۸�uB≏튩&��>�Tl�l���݋+j�iF�56S��	ףFZ�@Y�����g�+��?�?�0vEi�B gӪn �I�\,���8�a��k7<�16]"��ƮIl���^�j��L����E�s�K�T�gд�}0|��l?
Y��c��H�����$�8
�6��}      P   Y   x�3��2�wt���2�t��s
�t�q�2�s��2��pq�prt��2ʇ�r�s��z��ƃt[p�� UZ"D��=... M��     