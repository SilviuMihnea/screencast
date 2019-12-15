namespace java solas.projects.common.solas.projects.common.provider

exception InvalidOperationException {
    1: i32 code,
    2: string description
}

struct TImage{
    1: binary data;
}

service TService{

    TImage getImage() throws (1:InvalidOperationException e)


}
