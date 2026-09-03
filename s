[33mcommit 4715f4780d04db205c173de00565642fcbc80984[m[33m ([m[1;36mHEAD[m[33m -> [m[1;32mmain[m[33m)[m
Author: Daira Mazza <daira0796@hotmail.com>
Date:   Thu Sep 3 18:35:01 2026 -0300

    Se agrega ajuste en test traer festival y unidad de venta

[33mcommit e83b3c97bdf23e73f10cc6f0400aae501adcc933[m[33m ([m[1;31morigin/main[m[33m, [m[1;31morigin/HEAD[m[33m)[m
Author: Facundo D'addese <facundo.daddese19@gmail.com>
Date:   Thu Sep 3 16:17:25 2026 -0300

    Se agrega un ultimo try catch al TestAsignarStaff que valida si existe o no la unidad de venta

[33mcommit 6944c5bdd3c3dfbe0f993c03ac8229b9045ad0fa[m
Merge: c077a1f 98bb0ac
Author: Facundo D'addese <facundo.daddese19@gmail.com>
Date:   Thu Sep 3 15:56:15 2026 -0300

    Merge branch 'main' of https://github.com/facudaddese/TPGrupalOO2Hito1Grupo05

[33mcommit 98bb0ac5e33ef8812f357e20f530ace43c99cb55[m
Merge: ada773a a673dd7
Author: Facundo D'Addese <62414019+facudaddese@users.noreply.github.com>
Date:   Thu Sep 3 15:34:07 2026 -0300

    Merge pull request #15 from facudaddese/feature/unidad-de-venta
    
    Creado agregarStaff y agregarPlato, pendiente de validar su funcionam…

[33mcommit a673dd7cf75f5ddba46fc08cbd2bb82f7e89269f[m[33m ([m[1;31morigin/feature/unidad-de-venta[m[33m)[m
Author: Lautaro Gonzalez <lautarogonzalez1405@gmail.com>
Date:   Thu Sep 3 13:30:02 2026 -0300

    Implementado el agregar platos y creados los test

[33mcommit 68b884832bf160091f1ac95c11b537088c5bfe51[m
Merge: 2675d3e ada773a
Author: Lautaro Gonzalez <lautarogonzalez1405@gmail.com>
Date:   Thu Sep 3 12:36:27 2026 -0300

    Merge origin/main conflictos en UnidadDeVentaDao resueltos

[33mcommit 2675d3e06e8bc2778a5fe314def8bea12b5c192c[m
Author: Lautaro Gonzalez <lautarogonzalez1405@gmail.com>
Date:   Thu Sep 3 12:12:44 2026 -0300

    Implementacion y test funcional de asignarStaff

[33mcommit c077a1f1a590b629105817590a58a898d0ae837f[m
Merge: 965ee6c ada773a
Author: Facundo D'addese <facundo.daddese19@gmail.com>
Date:   Thu Sep 3 11:15:34 2026 -0300

    Merge branch 'main' of https://github.com/facudaddese/TPGrupalOO2Hito1Grupo05

[33mcommit ada773af8a0616714a79a7a98d2ce06c2010b36f[m
Merge: 46b0857 b7c6a4c
Author: Malena Rocio Lescano <84344304+MalenaLesc@users.noreply.github.com>
Date:   Thu Sep 3 00:52:27 2026 -0300

    Merge pull request #17 from facudaddese/rama-MalenaLesc
    
    Rama malena lesc

[33mcommit b7c6a4cdabadfdcea62d4f332ba19233bce75dc9[m[33m ([m[1;31morigin/rama-MalenaLesc[m[33m)[m
Author: Malena Rocio Lescano <84344304+MalenaLesc@users.noreply.github.com>
Date:   Thu Sep 3 00:49:20 2026 -0300

    Update use cases in README

[33mcommit 3c41556317e512b8b0e211a30cb6e4125bd88d00[m
Author: Male <lescano.mrl14@gmail.com>
Date:   Thu Sep 3 00:37:38 2026 -0300

    Update TraerPedidoYFestival.java

[33mcommit 835ff244557eaf7d2937a11d9051afbe36675151[m
Merge: b7c4753 46b0857
Author: Male <lescano.mrl14@gmail.com>
Date:   Thu Sep 3 00:24:05 2026 -0300

    Merge branch 'main' into rama-MalenaLesc

[33mcommit b7c4753c781fb2ca258afdfa30474490e7d1f009[m
Author: Male <lescano.mrl14@gmail.com>
Date:   Thu Sep 3 00:23:10 2026 -0300

    Test agregados para clases Pedido, ItemPedido y Plato

[33mcommit 46b085706676700d00ad67dbbcd9415db0921f62[m
Author: Daira Mazza <53192232+dairamazza1@users.noreply.github.com>
Date:   Wed Sep 2 23:29:45 2026 -0300

    Update README with Festival use case details
    
    Added details about the Festival and Unidades de Venta use case.

[33mcommit d1a1a9e89267a00aab100b3ebbbecf4c5aa908c0[m
Merge: 80bfb1e 40a8328
Author: Daira Mazza <53192232+dairamazza1@users.noreply.github.com>
Date:   Wed Sep 2 23:26:25 2026 -0300

    Merge pull request #16 from facudaddese/cambios-festival
    
    Relacion 1:N Festival-UnidadDeVenta y ajustes de mapeos/tests

[33mcommit 40a832858274701c95e04188198ce68aee158cbd[m[33m ([m[1;31morigin/cambios-festival[m[33m, [m[1;32mcambios-festival[m[33m)[m
Author: Daira Mazza <daira0796@hotmail.com>
Date:   Wed Sep 2 23:17:56 2026 -0300

    Relacion 1:N Festival-UnidadDeVenta y ajustes de mapeos/tests
    
    - Se agrega 'festival' a los constructores de UnidadDeVenta, FoodTruck y
      PuestoDesarmable, y a los metodos agregar del UnidadDeVentaABM
    - Mapeo Festival: set unidadesDeVenta (nombre y key id_festival corregidos)
    - Mapeo UnidadDeVenta: many-to-one festival reubicado antes de los joined-subclass
    - toString de Festival incluye unidadesDeVenta
    - Tests actualizados; se elimina TestAgregarCosto (costo depende de festival)
    
    Co-Authored-By: Claude Opus 4.8 <noreply@anthropic.com>

[33mcommit d18105d2cc06768207b84e0bb64554b1e3159b25[m
Author: Lautaro Gonzalez <lautarogonzalez1405@gmail.com>
Date:   Wed Sep 2 17:12:48 2026 -0300

    Creado agregarStaff y agregarPlato, pendiente de validar su funcionamiento en un test propio

[33mcommit 80bfb1e624dbb3be3726e840a0e1b52f507c3399[m
Merge: 04f8ee1 a57b21f
Author: Lautaro Gonzalez <lautarogonzalez1405@gmail.com>
Date:   Wed Sep 2 15:55:48 2026 -0300

    Merge pull request #13 from facudaddese/feature/unidad-de-venta
    
    Creados los test para dar de alta las unidades de venta en la BD

[33mcommit a57b21f47046d6a317afdf35dc4351614d431943[m
Author: Lautaro Gonzalez <lautarogonzalez1405@gmail.com>
Date:   Wed Sep 2 15:53:20 2026 -0300

    Creados los test para dar de alta las unidades de venta en la BD

[33mcommit 965ee6c82cab8b9b2449492809bd05d6ebff97a0[m
Merge: 9db0674 04f8ee1
Author: Facundo D'addese <facundo.daddese19@gmail.com>
Date:   Tue Sep 1 23:36:56 2026 -0300

    Merge branch 'main' of https://github.com/facudaddese/TPGrupalOO2Hito1Grupo05

[33mcommit 9db067480dd3d429b1df477c5ba9bdc6e304bc14[m
Author: Facundo D'addese <facundo.daddese19@gmail.com>
Date:   Tue Sep 1 23:33:22 2026 -0300

    Se elimina la firma duplicada traerPorDni en StaffABM

[33mcommit 04f8ee19e04df54958c44fe41cd99c4414fc6dcb[m
Merge: a502611 3c3bf24
Author: Malena Rocio Lescano <84344304+MalenaLesc@users.noreply.github.com>
Date:   Tue Sep 1 23:33:05 2026 -0300

    Merge pull request #12 from facudaddese/rama-MalenaLesc
    
    Rama malena lesc

[33mcommit 3c3bf245a5968f686a27a2e1644d852731aab3cb[m
Author: Male <lescano.mrl14@gmail.com>
Date:   Tue Sep 1 23:24:05 2026 -0300

    Validaciones agregadas en Plato e ItemPedido

[33mcommit bc043c57532180361262ef2828597598368d37a7[m
Author: Male <lescano.mrl14@gmail.com>
Date:   Tue Sep 1 23:23:11 2026 -0300

    Atributo Festival agregado a Pedido

[33mcommit a5026116f913e76fbea6af4606f527ccc7398616[m
Merge: 9dfbab8 9f6d601
Author: Malena Rocio Lescano <84344304+MalenaLesc@users.noreply.github.com>
Date:   Tue Sep 1 23:14:39 2026 -0300

    Merge pull request #11 from facudaddese/rama-MalenaLesc
    
    Rama malena lesc

[33mcommit 9f6d601b4931388f7ebbe10e7bd558906c825b13[m
Merge: 31eb028 9dfbab8
Author: Male <lescano.mrl14@gmail.com>
Date:   Tue Sep 1 23:11:19 2026 -0300

    Merge remote-tracking branch 'origin/main' into rama-MalenaLesc

[33mcommit 31eb028784152ec4c9f3bb94fbe8ec8157b93020[m
Author: Male <lescano.mrl14@gmail.com>
Date:   Tue Sep 1 23:02:32 2026 -0300

    Traer archivos

[33mcommit 260112f41bf4e73426b8d71d2e4d123e6fcc1456[m
Author: Male <lescano.mrl14@gmail.com>
Date:   Tue Sep 1 22:41:57 2026 -0300

    Agregado: Staff traerPorDni

[33mcommit 9dfbab82f5dfcfa73ea813a0dc425fb6c1e879c5[m
Merge: a9aa1c6 110c987
Author: Facundo D'Addese <62414019+facudaddese@users.noreply.github.com>
Date:   Tue Sep 1 22:12:55 2026 -0300

    Merge pull request #10 from facudaddese/rama-facundo-daddese
    
    Rama facundo daddese

[33mcommit 110c98766e81f29fde00325814d2ee580e0599aa[m[33m ([m[1;31morigin/rama-facundo-daddese[m[33m)[m
Merge: f6e5b07 a9aa1c6
Author: Facundo D'addese <facundo.daddese19@gmail.com>
Date:   Tue Sep 1 22:12:32 2026 -0300

    se agrega la firma traerPorDni en StaffABM

[33mcommit f6e5b0739e77e4e16c00ab00ade1981965109314[m
Merge: 1d5ac10 dcafaaf
Author: Facundo D'addese <facundo.daddese19@gmail.com>
Date:   Tue Sep 1 22:05:47 2026 -0300

    Merge branch 'rama-facundo-daddese' of https://github.com/facud