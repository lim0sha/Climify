export const toCelsium = (farengheits) => {
    return Math.round(((farengheits - 32) / 1.8) * 10) / 10;
}

export const mphToMs = (mph) => {
    return Math.round(mph / 2.2355 * 10) / 10;
}

export const mPaToMmHg = (mPa) => {
    return Math.round(mPa * 0.75 * 10) / 10
}