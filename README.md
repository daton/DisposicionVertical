# Proyecto de soluciones móviles

## Entregable Número 2:
1. Establecer una activity de logeo y ponerla como activity principal

2. Agregar un formulario con login y password

3.  Agregar dependencias para llevar a cabo validaciones

```
    implementation 'com.mobsandgeeks:android-saripaar:2.0.2'
```

## Manejo de validaciones en Android

Primero implementamos la interface  siguiente:
```
Validator.ValidationListener
```
Después vamos a implementar los métodos onNavigationFaildeg y on NavigationSuccedd

```
    override fun onValidationFailed(errors: MutableList<ValidationError>?) {
       //Aqui van las acciones  a tomar en caso de validaciones erroneas 
       var mensa="men"

        for (error in errors!!) {
            val view = error.view

            mensa=error.getCollatedErrorMessage(applicationContext)
        }
    }

    override fun onValidationSucceeded() {
       //Aqui van acciones a tomar si la validación fue exitosa
    }
```

Despues declaramos un atributo del tipo relacionado al campo que deseamos validar, aunque no necesariamente con el mismo nombre, y lo anotamos como por ejemplo:
```
  @Email
    private var login:EditText?=null
    
    
```

Iniciamos inmediatamente abajo del setContentView  los validadores y el campos ue vamos a validar lo asignamos a la vista correspondiente


```
        var validator = Validator(this);
        validator.setValidationListener(this);
        login= txtLogin

```
Finalmente en el cliqueo del botón invocar solamente el  metodo validate()

```
    validator.validate();
```

