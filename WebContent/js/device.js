function Device(id, x, y, name, switchable, imageDefault, imageSwitch) {
    this.id = id;
    this.x = x;
    this.y = y;
    this.name = name;
    this.switchable = switchable;
    this.value = null;   

    this.imageDefault = new Image();
    this.imageDefault.alt = name;
    this.imageDefault.src = imageDefault;

    //TO-DO: melhorar
    this.webcamImage = null;
    this.webcamImageLast = null;

    if (imageSwitch !== undefined && imageSwitch !== '') {
        this.imageSwitch = new Image();
        this.imageSwitch.alt = name;
        this.imageSwitch.src = imageSwitch;
    } else {
        this.imageSwitch = null;
    }

    this.getRight = function() {
        return this.x + this.getImage().width;
    };

    this.getBottom = function() {
        return this.y + this.getImage().height;
    };
    
    this.getImage = function() {
        if (this.imageSwitch !== null && (this.value === 1 || this.value === '1')) {
            return this.imageSwitch;
        }
        return this.imageDefault;
    };

    this.isIn = function(x, y) {
        return this.x <= x
                && this.getRight() >= x
                && this.y <= y
                && this.getBottom() >= y;
    };

    this.draw = function(context, isPressed) {       
        context.save();
        
        if (isPressed) {
            context.shadowColor = 'yellow';
            context.shadowBlur = 20;
        }
               
        context.drawImage(this.getImage(), this.x, this.y);
        context.lineWidth = 1; 
        context.strokeStyle = 'white';
        
        if (this.value !== null) {
            context.strokeText(this.value, this.x, this.getBottom());
            context.fillText(this.value, this.x, this.getBottom());              
        }
        context.restore();
        
        //force repaint out from cache. TO-DO: Add a device parameter?
        if (this.imageDefault.src.indexOf('webcam') !== -1) {
            webcamImage = new Image();
            webcamImage.src = this.imageDefault.src;
            webcamImage.onload = function() {
                context.drawImage(webcamImage, x, y);
                imageDefault = webcamImage;
            };
        }
    };

}